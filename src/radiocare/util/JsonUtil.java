package radiocare.util;
// ai generated code just to get it going tw n3awdouh hetha
// testing the branch thing
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public final class JsonUtil {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()                                          // readable file
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) // how to save/load dates
            .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter()) // same for times
            .create();

    private JsonUtil() { }

    public static Gson gson() {
        return GSON;
    }

    // LocalDate <-> "2001-05-14"
    private static class LocalDateAdapter extends TypeAdapter<LocalDate> {
        @Override
        public void write(JsonWriter out, LocalDate value) throws IOException {
            if (value == null) out.nullValue(); else out.value(value.toString());
        }
        @Override
        public LocalDate read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) { in.nextNull(); return null; }
            return LocalDate.parse(in.nextString());
        }
    }

    // LocalTime <-> "08:30"
    private static class LocalTimeAdapter extends TypeAdapter<LocalTime> {
        @Override
        public void write(JsonWriter out, LocalTime value) throws IOException {
            if (value == null) out.nullValue(); else out.value(value.toString());
        }
        @Override
        public LocalTime read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) { in.nextNull(); return null; }
            return LocalTime.parse(in.nextString());
        }
    }
}