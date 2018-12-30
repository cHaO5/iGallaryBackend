package j2ee.demo.elasticsearch;

import j2ee.demo.model.Moment;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="elasticsearch", type="moment")
public class MomentDocument extends Moment {
}
