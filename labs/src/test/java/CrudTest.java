import database.CandidateDao;
import database.JdbcUtils;
import database.OfferDao;
import model.Candidate;
import model.Offer;
import model.TestDataProvider;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CrudTest {
    private JdbcUtils jdbcUtils;
    private CandidateDao candidateDao;
    private OfferDao offerDao;

    @Before
    public void init(){
        jdbcUtils = new JdbcUtils();
        candidateDao=new CandidateDao(jdbcUtils);
        offerDao = new OfferDao(jdbcUtils);
    }
    @Test
    public void candidateCrudTest(){
        Candidate candidate = TestDataProvider.getCandidates().get(0);

        candidateDao.create(candidate);
        Candidate expected=candidateDao.read(1);
        assertEquals(expected,candidate);

        candidate.setAge(31);
        candidateDao.update(1,candidate);
        expected=candidateDao.read(1);
        assertEquals(expected,candidate);

        candidateDao.delete(1);
        assertNull(candidateDao.read(1));
    }

    @Test
    public void offerCrudTest(){
        Offer offer=TestDataProvider.getOffer();
        offer.setCandidates(null);
        offerDao.create(offer);
        Offer expected=offerDao.read(1);
        assertEquals(expected,offer);

        offer.setSalary(10f);
        offerDao.update(1,offer);
        expected=offerDao.read(1);
        assertEquals(expected,offer);

        offerDao.delete(1);
        assertNull(offerDao.read(1));
    }
}
