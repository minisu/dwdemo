import static java.time.DayOfWeek.FRIDAY;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import java.time.DayOfWeek;

public class DemoConfiguration extends Configuration {

    @JsonProperty
    private DayOfWeek defaultPartyDay = FRIDAY;

    public DayOfWeek getDefaultPartyDay() {
        return defaultPartyDay;
    }
}
