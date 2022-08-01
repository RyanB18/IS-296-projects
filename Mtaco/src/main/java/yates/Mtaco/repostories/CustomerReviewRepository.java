package yates.Mtaco.repostories;

import org.springframework.data.mongodb.repository.MongoRepository;
import yates.Mtaco.models.CustomerReview;


import java.util.List;

public interface CustomerReviewRepository extends MongoRepository<CustomerReview, String> {
    List<CustomerReview> findByProductDescriptionContaining(String productionDescription);
    List<CustomerReview> findByActionNeeded(boolean actionNeeded);
}
