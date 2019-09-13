package entities;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Item {
	
    private String title;
    private Integer categoryId;
    private Object[] customFields;
    private int id;
    private Category category;
    private String name;
	private String itemTag;
	private String description;
	private String categoryTitle;
	
	
	

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("custom_fields")
    public Object[] getCustomFields() {
        return customFields;
    }

    public void setCustomFields(Object[] customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Item tag")
	public String getItemTag() {
		return itemTag;
	}

	public void setItemTag(String itemTag) {
		this.itemTag = itemTag;
	}

	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("Category")
	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", categoryId=" + categoryId + ", customFields=" + Arrays.toString(customFields)
				+ ", id=" + id + ", category=" + category + ", name=" + name + ", itemTag=" + itemTag + ", description="
				+ description + ", categoryTitle=" + categoryTitle + "]";
	}
	
	
}
