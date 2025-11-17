package composite_key;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class MyId implements Serializable {
	private String email;
	private long phone;

}
