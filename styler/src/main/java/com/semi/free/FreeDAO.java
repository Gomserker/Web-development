package com.semi.free;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.main.DBManager;


public class FreeDAO {

	public static void getAllText(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from post order by p_date desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Post> posts = new ArrayList<Post>();
			Post p = null;
			while (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_user(rs.getString("p_user"));
				p.setP_date(rs.getDate("p_date"));
				
				posts.add(p);
			}

			request.setAttribute("posts", posts);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void getFreeDetail(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from post where p_no =?";

		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();

			Post p = null;
			if(rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_user(rs.getString("p_user"));
				p.setP_img(rs.getString("p_img"));
			}
				request.setAttribute("p", p);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void getNextFreeDetail(HttpServletRequest request) {
		//������
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from post where p_date >(select p_date from post where p_no =?)and rownum = 1";
		
		
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			
			Post p = null;
			if(rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_user(rs.getString("p_user"));
				p.setP_img(rs.getString("p_img"));
			}
			request.setAttribute("nextP", p);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	public static void getPrevFreeDetail(HttpServletRequest request) {
		//������
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from (select * from post order by p_date desc) "
				+ "	where p_date <(select p_date from post where p_no =?) and rownum =1";
		
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("no"));
			rs = pstmt.executeQuery();
			
			Post p = null;
			if(rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_text(rs.getString("p_text"));
				p.setP_date(rs.getDate("p_date"));
				p.setP_user(rs.getString("p_user"));
				p.setP_img(rs.getString("p_img"));
			}
			request.setAttribute("prevP", p);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void writeFree(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into post values(post_seq.nextval, ?, ?, ?, sysdate, ?, '0')";

		try {
			String saveDirectory = request.getSession().getServletContext().getRealPath("free/img");
			System.out.println(saveDirectory);
			
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy()); 

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			System.out.println(mr.getParameter("title"));
			System.out.println(mr.getParameter("text"));
			System.out.println(mr.getFilesystemName("img"));
			System.out.println(mr.getParameter("user"));
			
			pstmt.setString(1, mr.getParameter("title"));
			pstmt.setString(2, mr.getParameter("text"));
			pstmt.setString(3, mr.getFilesystemName("img"));
			pstmt.setString(4, mr.getParameter("user"));
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("��ϼ���");
			} else {
				System.out.println("��Ͻ���");

			}
			 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB����");

		} finally {
			DBManager.close(con, pstmt, null);
		}

		
	}

	
	public static void getNoticeList(HttpServletRequest request) {
		// ?~? �Խñ�
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				int page = 0;
				if (request.getParameter("pageNum") == null) {
					page = 1;
				}else {
					page = Integer.parseInt(request.getParameter("pageNum"));
				}
				
			//	int startNum = page-(page-1)%5;
				//int lastNum = 23;
				String sql = "select * from ( select rownum num, P.* from (select * from post order by p_date desc) P)"
						+ " where num between ? and ?";

				try {
					con = DBManager.connect();
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, 1+(page-1)*10);
					pstmt.setInt(2, page*10);
					rs = pstmt.executeQuery();

					ArrayList<Post> posts = new ArrayList<Post>();
					Post p = null;
					while (rs.next()) {
						p = new Post();
						p.setP_no(rs.getString("p_no"));
						p.setP_title(rs.getString("p_title"));
						p.setP_user(rs.getString("p_user"));
						p.setP_date(rs.getDate("p_date"));
						
						posts.add(p);
					}

					request.setAttribute("posts", posts);
					request.setAttribute("p", page);
				//	request.setAttribute("sn", startNum);
					//request.setAttribute("ln", lastNum);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBManager.close(con, pstmt, rs);
				}
	}
	public static void doSearch(HttpServletRequest request) {
		// ?~? �Խñ�
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int page = 0;
		if (request.getParameter("pageNum") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		String searchType = request.getParameter("selected");
		
		String sql = "select * from ( select rownum num, P.* from (select * from post where " + searchType + " like '%'||?||'%' order by p_date desc) P)"
				+ " where num between ? and ?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("searchText"));
			pstmt.setInt(2, 1+(page-1)*10);
			pstmt.setInt(3, page*10);
			rs = pstmt.executeQuery();
			
			ArrayList<Post> posts = new ArrayList<Post>();
			Post p = null;
			while (rs.next()) {
				p = new Post();
				p.setP_no(rs.getString("p_no"));
				p.setP_title(rs.getString("p_title"));
				p.setP_user(rs.getString("p_user"));
				p.setP_date(rs.getDate("p_date"));
				
				posts.add(p);
			}
			
			request.setAttribute("posts", posts);
			request.setAttribute("p", page);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
				
				public static void paging(HttpServletRequest request) {
					// ��������ȣó��
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
					int pagePerList = 10;
					int pagingCount = 10;
					// ��ü�Խù� ���� ����������
					int totalContent =0;
					int totalPage =0;
					 //���۰� �� ������
					int startPage, endPage;
					
					int page = 0;
					if (request.getParameter("pageNum") == null) {
						page = 1;
					}else {
						page = Integer.parseInt(request.getParameter("pageNum"));
					}
					
					
					// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
					
					String sql = "select count(*) from post";
					
					try {
						con = DBManager.connect();
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();
						
						while (rs.next()) {

							totalContent += rs.getInt(1);
							
						}
						
						totalPage = totalContent/ pagePerList;
						if (totalContent%pagePerList>0) {
							totalPage++;
						}
						
						//����¡���� ���
						startPage= ((page-1)/pagingCount)*pagingCount+1 ;
						endPage = startPage + pagingCount -1;
						
						if (endPage>totalPage) {
							endPage=totalPage;
						}
						
						int[]startEnd = new int [2];
						
						startEnd[0] = startPage;
						startEnd[1] = endPage;
						
						ArrayList<Integer> page_ = new ArrayList<Integer>();
						
						for (int i = startPage; i <= endPage; i++) {
							int j = i;
							page_.add(j);
							
						}
						System.out.println(page_);
						
							//for (int i = paging[0]; i <= paging[1]; i++) {
					

					//	&nbsp&nbsp

						
						//	}
						request.setAttribute("startEnd", page_);
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DBManager.close(con, pstmt, rs);
					}

			}
				public static void searchPaging(HttpServletRequest request) {
					// ��������ȣó��
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
					int pagePerList = 10;
					int pagingCount = 10;
					// ��ü�Խù� ���� ����������
					int totalContent =0;
					int totalPage =0;
					//���۰� �� ������
					int startPage, endPage;
					
					int page = 0;
					if (request.getParameter("pageNum") == null) {
						page = 1;
					}else {
						page = Integer.parseInt(request.getParameter("pageNum"));
					}
					
					
					// �� ȭ�鿡 ������ ����Ʈ ����, ����¡ ������ ����
					String searchType = request.getParameter("selected");
					String searchText = request.getParameter("searchText");
					String sql = "select count(*) from post where " + searchType + " like '%'||?||'%' order by p_date desc";
					
					try {
						con = DBManager.connect();
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, searchText);
						rs = pstmt.executeQuery();
						
						while (rs.next()) {
							
							totalContent += rs.getInt(1);
							
						}
						
						totalPage = totalContent/ pagePerList;
						if (totalContent%pagePerList>0) {
							totalPage++;
						}
						
						//����¡���� ���
						startPage= ((page-1)/pagingCount)*pagingCount+1 ;
						endPage = startPage + pagingCount -1;
						
						if (endPage>totalPage) {
							endPage=totalPage;
						}
						
						int[]startEnd = new int [2];
						
						startEnd[0] = startPage;
						startEnd[1] = endPage;
						
						ArrayList<Integer> page_ = new ArrayList<Integer>();
						
						for (int i = startPage; i <= endPage; i++) {
							int j = i;
							page_.add(j);
							
						}
						System.out.println(page_);
						
						//for (int i = paging[0]; i <= paging[1]; i++) {
						
						
						//	&nbsp&nbsp
						
						
						//	}
						System.out.println(searchText);
						request.setAttribute("startEnd", page_);
						request.setAttribute("selected", searchType);
						request.setAttribute("searchText", searchText);
						
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						DBManager.close(con, pstmt, rs);
					}
					
				}
		
				public static void upadateFreeDetail(HttpServletRequest request) {
					
					Connection con = null;
					PreparedStatement pstmt = null;

					
					//��¥ date������
					//r_date=sysdate�߰�
					String sql = "update post set p_title=?, p_text=?, p_img=? where p_no=?";

					try {
						con = DBManager.connect();
						pstmt = con.prepareStatement(sql);

						String saveDirectory = request.getSession().getServletContext().getRealPath("free/img");
						System.out.println(saveDirectory);
						
						MultipartRequest mr = new MultipartRequest(request, saveDirectory, 30 * 1024 * 1024, "utf-8",
								new DefaultFileRenamePolicy()); 


						System.out.println(mr.getParameter("title"));
						System.out.println(mr.getParameter("text"));
						System.out.println(mr.getFilesystemName("img"));
						System.out.println(mr.getParameter("no"));
						
						pstmt.setString(1, mr.getParameter("title"));
						pstmt.setString(2, mr.getParameter("text"));
						pstmt.setString(3, mr.getFilesystemName("img"));
						pstmt.setString(4, mr.getParameter("no"));
						
						if (pstmt.executeUpdate() == 1) {
							System.out.println("��������");
						} else {
							System.out.println("��������");

						}

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("DB����");

					} finally {
						DBManager.close(con, pstmt, null);
					}

				}

				public static void deleteFreeDetail(HttpServletRequest request) {

					Connection con = null;
					PreparedStatement pstmt = null;

					
					//��¥ date������
					//r_date=sysdate�߰�
					String sql = "delete post where p_no=?";

					try {
						con = DBManager.connect();
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, request.getParameter("no"));
						
						if (pstmt.executeUpdate() == 1) {
							System.out.println("��������");
						} else {
							System.out.println("��������");
						}

					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("DB����");

					} finally {
						DBManager.close(con, pstmt, null);
					}

				}
	
}
