package covid19testing.dao;

import covid19testing.model.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository {

	Test findTestByTestID(int testID)

	void deleteTestByTestID(int testID)

}
