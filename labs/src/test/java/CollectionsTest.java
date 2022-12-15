import model.Candidate;
import model.Offer;
import model.TestDataProvider;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CollectionsTest {
    @Test
    public void sortCandidatesTest(){
        Offer offer= TestDataProvider.getOffer();
        offer.sortCandidates();
        List<Candidate> candidates = offer.getCandidates();
        assertTrue(candidates.get(0).compareTo(candidates.get(1))<0 && candidates.get(1).compareTo(candidates.get(2))<0);
    }

    @Test
    public void testDeleteCandidatesWithoutEducation(){
        Offer offer = TestDataProvider.getOffer();
        offer.deleteCandidatesWithoutHigherEducation();
        assertEquals(offer.getCandidates().size(),1);
    }

    @Test
    public void addCandidateTest(){
        Offer offer = TestDataProvider.getOffer();
        offer.addCandidate(new Candidate());
        assertEquals(offer.getCandidates().size(),4);
    }
}
