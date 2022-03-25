package com.kandemirmert.bookstore.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    /**
     * @Adress ve @Author arasında ONE2ONE ilişki.
     */


    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
     String id;

    String country;

    String city;

    String town;

    String street;

    String doorNumber;

    String zipCode;


    /**
     * @cascade
     *
     * Şimdi biz eğer cascadeyi yazmazsak örneğin bir adres nesnesi kaydettik diyelim.
     * bu adres nesnesinin içinde bir author nesnesi var. Biz bu kayıdın iki tabloya da atılmasını istiyorsak cascadeyi kullanmamoz
     * gerekir.
     * Adres tablosunda authorla bağlantılı satıra işlem yaptığımda diğer nesnenin de bu işlemden etkilenmesini isityorum.
     *
     */
    @OneToOne(cascade = CascadeType.ALL)
    Author author;

    @OneToOne(cascade = CascadeType.ALL)
    BookPublisher bookPublisherAddress;



}