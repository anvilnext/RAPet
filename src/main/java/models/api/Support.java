package models.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Support{

	private String text;
	private String url;
}
