Hướng dẫn cài đặt project Quản Lý Học Phần HCMUNRE
- Đây là ứng dụng web viết bằng ngôn ngữ java sử dụng framewwork Spring boot
- Font-end: html,css, js 
- Back-end: java 
- Database: Mysql
- IDE: Intelij
1) Các yêu cầu cần có để chạy project:
- Có phần mềm hỗ trợ viết code java(cài đặt đầy đủ môi trường jdk,...)
- Có import database(project sử dụng db mysql)
- Có mysql workbench hoặc xampp để import database
2) Cách cài đặt 
- Import database vào trong cơ sở dữ liệu Đặt tên database giống như yêu cầu là: quanlyhocphan (Có thể đặt tùy thích nhưng phải đổi tên đường dẫn ở trong file application.properties)
- mở IDE rồi import project vào và làm mới reload file pom.xml để cập nhật các dependency
- Mở file application.properties và cật nhật lại mật khẩu và tài khoản ở bên dưới:
spring.datasource.username=root // root là username của mysql server
spring.datasource.password=5995 // 5995 là password của mysql server
spring.datasource.url=jdbc:mysql://localhost:3306/quanlyhocphan  // đây là đường dẫn connect với server mysql và quanlyhocphan là tên database
3) Chạy thử
Chạy thử và xem kết quả

PHÂN CÔNG CÔNG VIỆC
Nhóm 3 người
- Nguyễn Thanh Ý: Code phần quản lý
- Nguyễn Xuân Diệu: Code phần sinh viên
- Trần Lê Tiến Hòa: Code giao diện
