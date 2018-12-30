package j2ee.demo.elasticsearch;

import j2ee.demo.model.Moment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MomentDocumentService {
    Moment save(Moment moment);

    void delete(Moment moment);

    List<Moment> findByContent(String keyword);

    List<Moment> findByTags(String keyword);
}
