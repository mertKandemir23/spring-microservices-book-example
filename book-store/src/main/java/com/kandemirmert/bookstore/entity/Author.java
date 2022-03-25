package com.kandemirmert.bookstore.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    String authorName;

    String authorSurname;

    String authorAge;

    String authorBirthDay;


    /**
     * @mappedBy
     * Mappedby özelliği ev sahibi tarafın(owning side) kim olduğunu belirler.
     * Yani bir adresin bir kişisi mi olur yoksa Bir kişinin adresi mi olur?
     * Bu yüzden Address objesi içine atılan Author nesnesinin değişken adıyla burada mapliyoruz.
     */

    /**
     *
     * Diyelim ki biz sistemden bir person sildik ve bu personun adresininde diğer tabledan kalkmasını istiyorsak
     * Yani bağlı iki tabloda yaptığımız bi işlemin diğer tabloyuda etkilemesini istiyorsak burada CASCADE denen yapıyı
     * kullanıyoruz.
     *
     */
    @OneToOne(mappedBy = "author")
    Address authorAddress;
    /**
     * 1)Bu ilişkide tekil taraf yazar tarafı olduğu için onetomany anatasyonu ekledik.
     * 2)Burası owning side olduğu için mapped by buraya eklenecek
     * 3)Fetch kavramı fetch kavramı ONE2ONE için default olarak eagerdir.
     * Bu şu demektir sen bir datayı veritabanından istediğin zaman örneğin bu author nesnesi olsun
     * aynı zamanda agresif bi şekilde bağlantılı olduğu için book tablosunuda çeker
     * 4)Cascadeini ALL YAPALIM
     */
    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Set<Book> authorBooks;
}
