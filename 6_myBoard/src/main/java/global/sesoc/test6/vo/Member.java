package global.sesoc.test6.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String userid;
	private String userpwd;
	private String username; 
	private String gender; 
	private String phone;
	private String email;
	private String address;
}
