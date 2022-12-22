
# MemberVO

    package MariaDB;

    public class MemberVO {

        private int memberno;                       // 회원번호
        private String id;                          // 아이디
        private String name;                        // 이름

        public int getMemberno() {                  // memberno
            return memberno;
        }
        public void setMemberno(int memberno) {    
            this.memberno = memberno;
        }

        public String getId() {                     // id
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }

        public String getName() {                   // name
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
    
# MemberDAO

    package MariaDB;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

    public class MemberDAO {

        Connection conn = null; // 데이터베이스 접속 객체
        Statement stmt = null;  // SQL 쿼리를 구현한 객체
        ResultSet rs = null;    // 쿼리에 대한 응답 레코드셋을 가져오는 객체

        // 생성
        public MemberDAO(){
            try {
                Class.forName("org.mariadb.jdbc.Driver");       // MariaDB 드라이버 로드
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/mydb",   // Host
                        "root",                                 // 사용자
                        "1234"                                  // 암호
                );                                              // 데이터베이스 접속
            }catch (Exception e){
                e.printStackTrace();
                try {
                    conn.close();
                } catch (Exception ex) {
                    e.printStackTrace();
                }
            }
            if( conn != null) {
                System.out.println("데이터베이스 접속 성공!!");
            }
        }

        // 회원 정보 추가
        public int insert(MemberVO vo){
            int result = 0;
            try{
                String sql = "INSERT INTO member (memberno, id, name) VALUES (" + vo.getMemberno() + ", '" + vo.getId() + "', '" + vo.getName() + "')"; // 세미콜론은 안넣음
                stmt = conn.createStatement();      // statement 만들기
                result = stmt.executeUpdate(sql);   // 쿼리 수행
            }catch(Exception e){ e.printStackTrace(); }
            return result;                          // 정상적이면 1 반환
        }

        // 회원 정보 수정
        public int update(MemberVO vo){
            int result = 0;
            try {
                String sql = "UPDATE member SET id = '" + vo.getId() + "', name = '" + vo.getName() + "' WHERE memberno = " + vo.getMemberno();
                stmt = conn.createStatement();
                result = stmt.executeUpdate(sql);
            }
            catch (Exception e){ e.printStackTrace(); }
            return result;
        }

        // 회원 정보 삭제
        public int delete(int memberno){
            int result = 0;
            try{
                String sql = "DELETE FROM member WHERE memberno = " + memberno;
                stmt = conn.createStatement();
                result = stmt.executeUpdate(sql);
            }
            catch (Exception e){ e.printStackTrace(); }
            return result;
        }

        // 회원 정보 전체 조회
        public List<MemberVO> list(){
            List<MemberVO> list = new ArrayList<>();
            try{
                String sql = "SELECT * FROM member";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()){
                    MemberVO vo = new MemberVO();
                    vo.setMemberno(rs.getInt("memberno"));
                    vo.setId(rs.getString("id"));
                    vo.setName(rs.getString("name"));
                    list.add(vo);
                }
            }
            catch (Exception e){ e.printStackTrace(); }
            return list;
        }

        // 회원 정보 조회
        public MemberVO selectOne(int memberno){
            MemberVO vo = new MemberVO();
            try{
                String sql = "SELECT * FROM member WHERE memberno = " + memberno;
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()){
                    vo.setMemberno(rs.getInt("memberno"));
                    vo.setId(rs.getString("id"));
                    vo.setName(rs.getString("name"));
                }
            }catch(Exception e){ e.printStackTrace(); }
            return vo;
        }

        // 자원 해제
        public void close(){
            if(conn != null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    
# Main

    package MariaDB;

    import java.util.List;

    public class MemberMain {
        public static void main(String[] args) {

            MemberVO vo = null;
            MemberDAO dao = null;
            int r = 0;

            // 회원 정보 추가
            vo = new MemberVO();
            vo.setMemberno(0);
            vo.setId("gang");
            vo.setName("이강인");

            dao = new MemberDAO();
            r = dao.insert( vo );
            if( r > 0 ){ System.out.println("회원 정보 등록 성공!"); }

            // 회원 정보 조회
            vo = dao.selectOne(2);
            System.out.println("회원 정보 출력");
            System.out.println("회원번호 : " + vo.getMemberno());
            System.out.println("아이디 : " + vo.getId());
            System.out.println("이름 : " + vo.getName());

            // 회원 정보 수정
            vo.setMemberno(0);
            vo.setId("ho");
            vo.setName("호날두형");
            r = dao.update(vo);
            if( r > 0 ){ System.out.println("회원정보 수정 성공!"); }

            // 회원 정보 전체 조회
            System.out.println("회원 목록 조회");
            List<MemberVO> list = dao.list();
            for(int i=0; i<list.size(); i++){
                System.out.println("회원번호 : " + list.get(i).getMemberno());
                System.out.println("아이디 : " + list.get(i).getId());
                System.out.println("이름 : " + list.get(i).getName());
            }

            // 회원 정보 삭제
            r = dao.delete( 2 );
            if( r > 0 ){ System.out.println("회원 삭제 성공!"); }

            // 자원 해제
            dao.close();
        }
    }
  
