# RadioCare: Backlog

Root package: `radiocare`. Layers: `view → controller → service → dao → model`.

---

## 0. Decisions (before writing code)

- [X] Decide associations: **IDs** (spec-literal, simpler JSON) or **object references** (needs a Gson adapter).
- [ ] Decide the debtor-balance threshold for Conflict 5 (e.g. `SEUIL_SOLDE_DEBITEUR = 500`)
- [ ] Decide how the Patient contraindication is represented (e.g. `String contreIndications`)

## 1. Project setup

- [X] Create project
- [X] Create packages: `model`, `model.enums`, `dao`, `service`, `service.conflict`, `controller`, `view`, `exception`, `util`
- [ ] Create `data/` folder at project root for JSON files
- [ ] Create `Main.java`
- [X] Init git repo + `.gitignore`

## 2. Enums (`model.enums`)

- [X] `TypeEquipement` (IRM, SCANNER_CT, TABLE_RX, ECHOGRAPHE)
- [X] `StatutEquipement` (EN_SERVICE, EN_PANNE, EN_MAINTENANCE)
- [X] `Habilitation` (IRM, SCANNER, RAYONS_X)
- [X] `Specialite` (NEURORADIOLOGIE, OSTEO, THORACIQUE)
- [X] `StatutRendezVous` (PLANIFIE, EN_COURS, REALISE, ANNULE)
- [X] `CodeResultat` (NORMAL, ANOMALIE, URGENT)
- [X] `StatutPaiement` (REGLEE, EN_ATTENTE, RETARD)
- [X] `ModePaiement` (ESPECES, CHEQUE, CARTE, VIREMENT)
- [X] `TypeConflit` (5 values, one per conflict)

## 3. Model (POJOs only: fields, constructors, getters/setters, equals/hashCode on ID, toString)

- [X] `Creneau` (jour, debut, fin)
- [X] 1. `Patient` (+ contraindication field)
- [X] 2. `MedecinRadiologue` (`List<Creneau> dispoPlanning`)
- [X] 3. `ManipulateurRadio` (+ `heuresGarde`)
- [X] 4. `EquipementImagerie`
- [X] 5. `SalleRadiologie`
- [X] 6. `ExamenMedical`
- [X] 7. `RendezVous`
- [ ] 8. `CompteRenduMedical`
- [ ] 9. `FactureMedicale`
- [ ] 10. `Paiement`
    (consulte each other before doing this one)
- [ ] `DepenseMaintenance` (equipment, date, amount, invoice ref) 

## 4. Infrastructure

- [X] `dao`: `GenericDAO<T,ID>` interface
- [ ] `dao`: `JsonDAO<T,ID>` (load all at startup into `Map`, flush on every write, return shared instances)
- [ ] Test `JsonDAO` with `Patient` only (save, reload after restart)
- [ ] `exception`: `ConflictException`, `EntityNotFoundException`
- [ ] `util`: `JsonUtil` (Gson setup + `LocalDate`/`LocalTime` adapters)
- [ ] `util`: ID generator (e.g. `P001`, `RDV042`)
- [ ] `util`: `InputUtil` (safe console reading) if console UI
- [ ] If using objects: custom Gson adapter writing only the ID, resolved after load in dependency order

## 5. First vertical slice: Patient (F1)

- [ ] `PatientDAO`
- [ ] `PatientService` (CRUD + validation: unique CIN, email format, etc.)
- [ ] `PatientController`
- [ ] `PatientView` (add, edit, delete, search, show record)
- [ ] Verify `patients.json` is written and reloaded correctly
- [ ] Review the architecture before copying the pattern

## 6. Simple CRUD slices (copy the Patient pattern)

- [ ] `MedecinRadiologue`: DAO, service, controller, view
- [ ] `ManipulateurRadio`: DAO, service, controller, view
- [ ] `EquipementImagerie`: DAO, service, controller, view
- [ ] `SalleRadiologie`: DAO, service, controller, view (validate that an equipment is not assigned to two rooms)
- [ ] `ExamenMedical`: DAO, service, controller, view
- [ ] Block deletion of an entity that is still referenced (patient with RDVs, equipment in a room, etc.)

## 7. Scheduling and conflict engine (F4, the core of the project)

- [ ] `RendezVousDAO`, `RendezVousService`, `RendezVousController`, `RendezVousView`
- [ ] `ConflictEngine` (receives the DAOs it needs; `verifier()` returns all violations)
- [ ] Availability check against doctor `dispoPlanning`
- [ ] Conflict 1: double booking of room / equipment
- [ ] Conflict 2: doctor / manipulateur schedule overlap
- [ ] Conflict 3: equipment hours quota exceeded before maintenance
- [ ] Conflict 4: manipulateur missing the IRM / Scanner habilitation
- [ ] Conflict 5: patient medical contraindication or debtor balance too high
- [ ] JUnit test for each conflict (one passing case, one failing case)
- [ ] Weekly planning display: `[Heure - Patient - Examen - Salle - Équipement - Médecin - Manipulateur]` (`LignePlanning`)
- [ ] RDV status transitions (PLANIFIE → EN_COURS → REALISE / ANNULE)

## 8. Medical records and billing (F5, F6)

- [ ] `CompteRenduMedical`: DAO, service, controller, view (store prescription ref and diagnosis text, F6)
- [ ] `FactureMedicale`: DAO, service (HT → TVA 19% → TTC, insurance share vs patient share)
- [ ] Auto-create the invoice when a RDV becomes REALISE
- [ ] `Paiement`: DAO, service (store proof reference, update invoice status and patient `soldeCompte`)
- [ ] Patient record summary (`BilanPatient`): exam history, total acts, insurance share, paid, remaining (F1)
- [ ] Monthly financial reconciliation (`BilanMensuel`): expenses (maintenance, salaries/honoraires) vs revenue (F5)

## 9. Equipment wear and maintenance alerts (F2)

- [ ] Decrement `heuresRestantesMaintenance` and increase `heuresCumulees` when a RDV becomes REALISE
- [ ] Maintenance usage report (`RapportMaintenance`)
- [ ] Alert (`Alerte`) when remaining hours are below a threshold
- [ ] `DepenseMaintenance`: DAO + textual entry of spare-part invoices

## 10. Staff pay (F3)

- [ ] Monthly doctor fees: percentage of the acts performed (`PersonnelService`)
- [ ] Monthly manipulateur salary: worked hours + guard hours
- [ ] Wire both results into the monthly balance (F5)

## 11. Persistence check (F7)

- [ ] One JSON file per entity (`patients.json`, `equipements.json`, ...)
- [ ] App starts with missing/empty JSON files without crashing
- [ ] Full restart test: create data, quit, relaunch, data is intact

## 12. Menu and UI polish

- [ ] `MainView` main menu linking all modules
- [ ] Consistent error messages when a conflict is raised (list all violations)
- [ ] Input validation (dates, numbers, empty fields)
- [ ] Controllers contain no business logic, views contain no business logic (check once)

---
