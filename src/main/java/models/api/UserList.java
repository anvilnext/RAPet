package models.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserList{
	private int perPage;
	private int total;
	private List<DataItem> data;
	private int page;
	private int totalPages;
	private Support support;
}