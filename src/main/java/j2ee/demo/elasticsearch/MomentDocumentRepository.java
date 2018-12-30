package j2ee.demo.elasticsearch;

import j2ee.demo.model.Moment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MomentDocumentRepository extends ElasticsearchRepository<Moment, Integer> {

    List<Moment> findByContent(String keyword);

    List<Moment> findByTags(String keyword);
}
