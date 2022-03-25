package com.kandemirmert.bookstore.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    /**
     * @book ve @author
     * arasında ONE TO MANY MANY TO ONE İLİŞKİSİ
     */


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    String bookName;

    String pageNumber;

    BigDecimal amount;


    String releaseDate;

    String currency;

    String description;

    LocalDateTime bookSystemRecordCreatedTime;

    LocalDateTime bookSystemRecordUpdateTime;

    /**
     * Her kitabın bir yazarı olur değil mi ? Yazar burada tekil tarafta Book ise çoğul tarafta
     * Book kısmı çoğul olan kısım olduğu için many to one tarafı burası olacak
     */

    @ManyToOne
    Author author;

     @ManyToMany(mappedBy = "bookList",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    List<BookCategories> bookCategoriesList;

     @ManyToOne
     BookPublisher bookPublisher;








}
