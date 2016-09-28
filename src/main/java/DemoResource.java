import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.codahale.metrics.annotation.Timed;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("days-until-party")
@Produces(APPLICATION_JSON)
public class DemoResource {

    private final DayOfWeek defaultPartyDay;

    public DemoResource(DayOfWeek defaultPartyDay) {
        this.defaultPartyDay = defaultPartyDay;
    }

    @GET
    @Timed
    public long getDaysUntilParty(@QueryParam("party-day") Optional<DayOfWeek> partyDay) {
        LocalDate partyDate = LocalDate
            .now()
            .with(nextOrSame(partyDay.orElse(defaultPartyDay)));

        return DAYS.between(
            LocalDate.now(),
            partyDate
        );
    }
}
