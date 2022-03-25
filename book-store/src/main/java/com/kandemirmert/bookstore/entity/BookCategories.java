package com.kandemirmert.bookstore.entity;

import com.kandemirmert.bookstore.enums.BookCategoriesEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCategories {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    @Enumerated(EnumType.STRING)
    BookCategoriesEnum bookCategoriesEnum;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Book> bookList;
}
