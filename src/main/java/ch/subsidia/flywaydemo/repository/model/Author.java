package ch.subsidia.flywaydemo.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static ch.subsidia.flywaydemo.repository.model.EntityGraphs.AUTHOR_BOOKS;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = AUTHOR_BOOKS,
                attributeNodes = {
                        @NamedAttributeNode(value = Author_.BOOKS)
                }
        )
})
public class Author extends BaseEntity {

    @Column(nullable = false)
    private String artistName;

    @Column(nullable = false)
    private String preName;

    @Column(nullable = false)
    private String familyName;

    @Builder.Default
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();
}
