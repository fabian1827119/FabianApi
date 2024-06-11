package fsantillan.apijwt.Common.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

     long userId;
     long id;
     String title;
     String body;
 }
