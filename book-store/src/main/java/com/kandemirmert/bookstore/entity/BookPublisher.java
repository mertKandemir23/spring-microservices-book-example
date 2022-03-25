package com.kandemirmert.bookstore.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookPublisher {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    String publisherName;

    String publisherAddress;

    String publisherPhoneNumber;

    @OneToMany(mappedBy = "bookPublisher",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Set<Book> publishedBooks;

    @OneToOne(mappedBy = "bookPublisherAddress")
    Address address;

}
