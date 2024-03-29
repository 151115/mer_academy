<%@page import="com.model.MessageDTO"%>
<%@page import="com.model.MessageDAO"%>
<%@page import="com.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>
	<%MemberDTO dto = (MemberDTO) session.getAttribute("login_input");%>
										
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header" class="alt">
						<a href="index.html" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
						<nav>
							<%
								if (dto== null)
									out.print("<a href=\"#menu\">로그인</a>");
								else{
									
									out.print("<a href=\"Logout.do\">로그아웃</a>");
									out.print("<a href=\"update.jsp\">회원정보수정</a>");
									
								}
							%>
							<!-- 로그인 후 Logout.jsp로 이동할 수 있는'로그아웃'링크와 '개인정보수정'링크를 출력하시오. -->
						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
							<li><h5>로그인</h5></li>
								<form action="Login.do" method="post">
									<li><input name="email" type="text"  placeholder="Email을 입력하세요"></li>
									<li><input name="pw" type="password"  placeholder="PW를 입력하세요"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
							<li><h5>회원가입</h5></li>
								<form action="Join.do" method="post">
									<li><input name="email" type="text"  placeholder="Email을 입력하세요"></li>
									<li><input name="pw" type="password"  placeholder="PW를 입력하세요"></li>
									<li><input name="tel" type="text"  placeholder="전화번호를 입력하세요"></li>
									<li><input name="address" type="text"  placeholder="집주소를 입력하세요"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>		
					
						
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
										<h1><%
										if(dto !=null) out.print(dto.getEmail() +"님 환영합니다");			
										else out.print("로그인 후 이용해주세요");
										%>
										</h1>
								<!-- 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오.
									 ex)smart님 환영합니다 -->
							</header>
							<div class="content">
								<p>아래는 지금까지 배운 웹 기술들입니다.<br></p>
								<ul class="actions">
									<li><a href="#one" class="button next scrolly">확인하기</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">HTML</a></h3>
										<p>홈페이지를 만드는 기초 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">CSS</a></h3>
										<p>HTML을 디자인해주는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Servlet/JSP</a></h3>
										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">JavaScript</a></h3>
										<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
									</header>
								</article>
							</section>
					<!-- Two -->
							<section id="two">
								<div class="inner">
									<header class="major">
										<h2><%
										out.print("나에게 온 메세지 확인하기");
										%>
										</h2>
									</header>
									<p></p>
									<ul class="actions">
										<li><%
										 if(dto!=null ){
											out.print("<table><tr> <td>");
											out.print("번호 </td> <td>");
											out.print("보낸사람 </td> <td>");
											out.print("내용 </td> <td>");
											out.print("받은날짜</td> <td>");
											out.print("삭제하기 </td> </tr>");
											
										MessageDAO dao = new MessageDAO();
										ArrayList<MessageDTO> list = dao.select( dto.getEmail() );
										
										
										for (int i=0; i<list.size() ; i++){
											
											int num = list.get(i).getNum();
											String send_name = list.get(i).getSend_name();
											String receive_email = list.get(i).getReceive_email();
											String content = list.get(i).getContent();
											String sendDate= list.get(i).getSendDate();
											
											/* System.out.printf("%3d %s %s %s %s\n\n", num, send_name, receive_email, content , sendDate); */

											out.print("<tr> <td>");
											out.print(i+1);
											out.print("</td> <td>");
											out.print(send_name);
											out.print("</td> <td>");
											out.print(content);
											out.print("</td> <td>");
											out.print(sendDate);
											out.print("</td> <td>");
											out.print("<a href='MessageDelete.do?num=" +list.get(i).getNum() +"' class='button next scrolly '></a>");
											out.print("</td> </tr>");
											
										}
										out.print("</table>");
										} 
										//선생님 코드 
		
										/*  if(dto!=null ){

											MessageDAO dao = new MessageDAO();
											ArrayList<MessageDTO> list = dao.select( dto.getEmail() );
												
											for (int i=0; i<list.size() ; i++){
												out.print("<li>");
												out.print(list.get(i).getSend_name() +" : ");
												out.print(list.get(i).getContent() +" ");
												out.print(list.get(i).getSendDate());
												out.print("<a href='MessageDeloteCon?num=" +list.get(i).getNum() +"' class='button next scrolly '></a>");
		
												out.print("</li><br>");
											}
										}    */
										else out.print("로그인 후 이용해주세요");
										%><br>
										</li>
										<li><a href="MssageDeleteAll.do"+ class="button next scrolly">전체삭제하기</a></li>
									</ul>
								</div>
							</section>

					</div>

				<!-- Contact -->
					<section id="contact">
						<div class="inner">
							<section>
								<form action="Message.do" method="post">
								<div class="field half first">
										<label for="name">Name</label>
										<input name = "send_name" type="text"  id="name" placeholder="보내는 사람 이름" />
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input name="receive_email" type="text"  id="email" placeholder="보낼 사람 이메일"/>
									</div>

									<div class="field">
										<label for="message">Message</label>
										<textarea name="content" id="message" rows="6"></textarea>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon alt fa-envelope"></span>
										<h3>Email</h3>
										<a href="#">
										<%
										if(dto !=null) 
											out.print(dto.getEmail() +"님 환영합니다");
										else out.print("로그인 후 이용해주세요");
										%></a>
										<!-- 로그인 한 사용자의 이메일을 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-phone"></span>
										<h3>Phone</h3>
										<span><%
										if(dto!=null) out.print(dto.getTel());
										else out.print("로그인 후 이용해주세요");
										%>
										</span>
										<!-- 로그인 한 사용자의 전화번호를 출력하시오 -->
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-home"></span>
										<h3>Address</h3>
										<span><%
										if(dto!=null) 
											out.print(dto.getAddress());
										else out.print("로그인 후 이용해주세요");
										%></span>
										<!-- 로그인 한 사용자의 집주소를 출력하시오 -->
									</div>
								</section>
							</section>					
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>

