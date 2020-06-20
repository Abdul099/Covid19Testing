package covid19testing.dao;

import covid19testing.model.TestCenter;
import org.springframework.data.repository.CrudRepository;

public interface TestCenterRepository extends CrudRepository<TestCenter, String> {

    TestCenter FindTestCenterByName(String name);

    void deleteTestCenterByName(String name);

}
