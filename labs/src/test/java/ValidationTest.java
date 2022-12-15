import model.Candidate;
import model.Offer;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidationTest {
    @Test
    public void testOfferValidation(){
        assertThrows(IllegalArgumentException.class,()->{Offer.builder().salary(-1).build();});
        assertThrows(IllegalArgumentException.class,()->{Offer.builder().candidates(null).build();});
        assertThrows(IllegalArgumentException.class,()->{Offer.builder().description("").build();});
    }
    @Test
    public void testCandidate(){
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().name("").build();});
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().sex("helicopter").build();});
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().phone("phone").build();});
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().email("serhii#email.com").build();});
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().address("                                                                                               ").build();});
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().age(17).build();});
        assertThrows(IllegalArgumentException.class,()->{Candidate.builder().yearsOfExperience(-1).build();});
    }
}
