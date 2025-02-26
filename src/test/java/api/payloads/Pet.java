package api.payloads;

import java.util.ArrayList;
import java.util.HashMap;

public class Pet {
	
		private int id;
		private String name;
	    private HashMap<String, Object> category;
	    private ArrayList<String> photoUrls;
	    private HashMap <String,Object> tag;
	    private ArrayList<HashMap> tags;
	    private String status;

		
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public HashMap<String, Object> getCategory() {
			return category;
		}
		public void setCategory(HashMap<String, Object> categoryMap) {
			this.category = categoryMap;
		}
		public ArrayList<String> getPhotoUrls() {
			return photoUrls;
		}
		public void setPhotoUrls(ArrayList<String> photoUrls) {
			this.photoUrls = photoUrls;
		}
		public HashMap<String, Object> getTag() {
			return tag;
		}
		public void setTag(HashMap<String, Object> tag) {
			this.tag = tag;
		}
		public ArrayList<HashMap> getTags() {
			return tags;
		}
		public void setTags(ArrayList<HashMap> tagsListMap) {
			this.tags = tagsListMap;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		

}
