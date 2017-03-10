package cn.zju.dao.po;

import java.util.List;

public class PageBean {
	private List list;         //涓�椤电殑鎵�鏈夎褰�
	private int totalrecord;   //鎬诲叡澶氬皯鏉¤褰�
	private int pagesize;      //涓�椤垫湁鍑犳潯鏁版嵁
	private int totalpage;     //鎬诲叡澶氬皯椤�
	private int currentpage;   //鐢ㄦ埛鎯崇湅鐨勯〉
	private int previouspage;  //鎯崇湅鐨勯〉鐨勫墠涓�椤�
	private int nextpage;      //鎯崇湅鐨勯〉鐨勪笅涓�椤�
	private int[] pagebar;     //搴曚笅鐨� 1 2 3 ...椤电爜鏉�
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		
		return totalrecord;
	}
    public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	
	public int getTotalpage() {
		if(this.totalrecord==0){
			return 1;
		}else if(this.totalrecord%this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize+1;
		}
		return totalpage;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if(this.currentpage-1<1){
			this.previouspage = 1;
		}else{
			this.previouspage = this.currentpage-1;
		}
		return previouspage;
	}
	
	public int getNextpage() {
		if(this.currentpage+1>=this.totalpage){
			this.nextpage = this.totalpage;
		}else{
			this.nextpage = this.currentpage +1;
		}
		return nextpage;
	}
	
	
	public int[] getPagebar() {
		int startpage;
		int endpage;
		int pagebar[] = null;
		if(this.totalpage<=10){                //濡傛灉椤电爜鎬诲叡涓嶈秴杩�10椤碉紝鍏ㄩ儴鏄剧ず鍑烘潵灏卞ソ浜�
			pagebar = new int[this.totalpage];
			startpage = 1;
			endpage = this.totalpage;
		}else{                                //鎬婚〉鏁板ぇ浜�10锛屾樉绀洪偦杩戠殑10椤�
			pagebar = new int[10];
			startpage = this.currentpage - 4;
			endpage = this.currentpage + 5;
			if(startpage<1){               //纭繚涓嶈兘瓒婄晫
				startpage = 1;
				endpage = 10;
			}
			
			if(endpage>this.totalpage){
				endpage = this.totalpage;
				startpage = this.totalpage - 9;
			}
		}
		
		int index = 0;
		for(int i=startpage;i<=endpage;i++){
			pagebar[index++] = i;
		}
		
		this.pagebar = pagebar;
		return this.pagebar;
		/*int pagebar[] = new int[this.totalpage];
		for(int i=1;i<=this.totalpage;i++){
			pagebar[i-1] = i;
		}
		this.pagebar = pagebar;
		return pagebar;*/
	}	
}
