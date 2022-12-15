package mapper;

import model.Candidate;
import model.Offer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultMapper {
    public static List<Offer> resolveOffers(ResultSet resultSet) throws SQLException {
        List<Offer> result = new ArrayList<>();
        while (resultSet.next()) {
            Offer offer=Offer.builder()
                    .description(resultSet.getString("DESCRIPTION"))
                    .salary(resultSet.getFloat("SALARY"))
                    .build();
            result.add(offer);
        }
        return result;
    }

    public static List<Candidate> resolveCandidates(ResultSet resultSet) throws SQLException{
        List<Candidate> result = new ArrayList<>();
        while (resultSet.next()) {
            Candidate candidate=Candidate.builder()
                    .age(resultSet.getInt("AGE"))
                    .sex(resultSet.getString("SEX"))
                    .email(resultSet.getString("EMAIL"))
                    .name(resultSet.getString("NAME_"))
                    .phone(resultSet.getString("PHONE"))
                    .address(resultSet.getString("ADDRESS"))
                    .haveHigherEducation(resultSet.getBoolean("HAVE_HIGHER_EDUCATION"))
                    .yearsOfExperience(resultSet.getInt("YEARS_OF_EXPERIENCE"))
                    .build();
            result.add(candidate);
        }
        return result;
    }
}
