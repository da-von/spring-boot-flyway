package ch.subsidia.flywaydemo.repository;

import ch.subsidia.flywaydemo.repository.model.Author;
import ch.subsidia.flywaydemo.repository.model.Author_;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphJpaSpecificationExecutor;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public interface AuthorRepository extends OverrideEntityGraphSimpleJpaRepository<Author, Long>,
        EntityGraphJpaSpecificationExecutor<Author> {

    default Optional<Author> findOne(long id) {
        return findOne(withId(id));
    }

    default Optional<Author> findOne(long id, EntityGraph entityGraph) {
        return findOne(withId(id), entityGraph);
    }

    default Optional<Author> findByAuthorId(long id) {
        return findById(id);
    }

    default Optional<Author> findByAuthorId(long id, EntityGraph entityGraph) {
        return findById(id, entityGraph);
    }

    private static Specification<Author> withId(long id) {
        return (a, cb, cq) -> cq.equal(a.get(Author_.id), id);
    }

}
