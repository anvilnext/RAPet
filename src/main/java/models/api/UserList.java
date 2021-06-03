package models.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserList{
	@JsonProperty("per_page")
	private int perPage;
	private int total;
	private List<DataItem> data;
	private int page;
	@JsonProperty("total_pages")
	private int totalPages;
	private Support support;
}