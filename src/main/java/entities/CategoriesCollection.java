package entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesCollection {

	private List<Object> customFields = null;
	private Object predefinedCategory;
	private Object predefinedCategoryId;
	private String name;
	private int itemsCount;
	private boolean needsApproval;
	private boolean inventoryType;
	private int defaultBookingLength;
	private int maxBookingLength;
	private int companyId;
	private String imageUid;
	private int id;

	@JsonProperty("custom_fields")
	public List<Object> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(List<Object> customFields) {
		this.customFields = customFields;
	}

	@JsonProperty("predefined_category")
	public Object getPredefinedCategory() {
		return predefinedCategory;
	}

	public void setPredefinedCategory(Object predefinedCategory) {
		this.predefinedCategory = predefinedCategory;
	}

	@JsonProperty("predefined_category_id")
	public Object getPredefinedCategoryId() {
		return predefinedCategoryId;
	}

	public void setPredefinedCategoryId(Object predefinedCategoryId) {
		this.predefinedCategoryId = predefinedCategoryId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("items_count")
	public int getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}

	@JsonProperty("needs_approval")
	public boolean isNeedsApproval() {
		return needsApproval;
	}

	public void setNeedsApproval(boolean needsApproval) {
		this.needsApproval = needsApproval;
	}

	@JsonProperty("inventory_type")
	public boolean isInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(boolean inventoryType) {
		this.inventoryType = inventoryType;
	}

	@JsonProperty("default_booking_length")
	public int getDefaultBookingLength() {
		return defaultBookingLength;
	}

	public void setDefaultBookingLength(int defaultBookingLength) {
		this.defaultBookingLength = defaultBookingLength;
	}

	@JsonProperty("max_booking_length")
	public int getMaxBookingLength() {
		return maxBookingLength;
	}

	public void setMaxBookingLength(int maxBookingLength) {
		this.maxBookingLength = maxBookingLength;
	}

	@JsonProperty("company_id")
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@JsonProperty("image_uid")
	public String getImageUid() {
		return imageUid;
	}

	public void setImageUid(String imageUid) {
		this.imageUid = imageUid;
	}

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}