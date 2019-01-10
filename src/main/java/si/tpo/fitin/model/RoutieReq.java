package si.tpo.fitin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutieReq {
    String name, description, author;
    Integer duration;
}
