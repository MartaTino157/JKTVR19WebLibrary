/**
 * Адгоритм создания web-приложения на java
 * 
 * 1. Создать WebApplication в NetBeans
 * 2. Создать сущностные классы с аннотациями в пакете Source Packeges/entity 
 * 3. Создать БД и настроить persistance.xml
 * 4. Создать сессионные Java Enterprice Beans для каждого сущностного класса с помощью помощника NetBeans()
 * 5. Создать страницы в формате jsp в разделе Web pages/WEB-INF 
 *    (папка служит для сокрытия ресурсов от прямого доступа через url)
 * 6. Создать сервлет "MyServlet" в папке Source Pakages/servlets
 * 7. Настроить параметр аннотации @WebServlet(urlPatterns={...})
 *    При запросе клиентя содержащего эти параметры будет выполняться метод ProcessRequest сервлета "MyServlet",
 *    который управляется веб-контейнером
 * 8. Получить текущий запрос из запроса "path"
 * 9. Обработать запрос через switch и, с помощью метода getRequestDispatcher(), отдать страничку jsp с данными клиенту.
 *    Например:
 *      request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
 * 10. Для получения объектов классов "фасадов" использовать аннотацию @EJB в поле класса "MyServlet"
 */
package servlets;
import entity.Book;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;
import session.ReaderFacade;
import session.UserFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "MyServlet", urlPatterns = {
    "/addBook",
    "/createBook",
    "/listBooks",
    "/addReader",
    "/createReader",
    "/listReaders"
    
})
public class MyServlet extends HttpServlet {
    @EJB
    private BookFacade bookFacade;
    @EJB
    private ReaderFacade readerFacade;
    @EJB
    private UserFacade userFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); // прописываем utf здесь
        String path = request.getServletPath();
        switch (path) {
            case "/addBook":
                request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String publishedYear = request.getParameter("publishedYear");
                if("".equals(name) || name == null
                        ||"".equals(author) || author == null
                        ||"".equals(publishedYear) || publishedYear == null){
                    request.setAttribute("name", name);
                    request.setAttribute("author", author);
                    request.setAttribute("publishedYear", publishedYear);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/WEB-INF/addBookForm.jsp").forward(request, response);
                    break;
                }   
                Book book = new Book(name, author, publishedYear);
                bookFacade.create(book);
                request.setAttribute("info", "Книга \"" + book.getName() + "\" добавлена");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listBooks":
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/listBooks.jsp").forward(request, response);
                break;
            case "/addReader":
                request.getRequestDispatcher("/WEB-INF/addReaderForm.jsp").forward(request, response);
                break;
            case "/createReader":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                if("".equals(lastname) || lastname == null
                        ||"".equals(lastname) || lastname == null
                        ||"".equals(phone) || phone == null){
                    request.setAttribute("firstname", lastname);
                    request.setAttribute("lastname", lastname);
                    request.setAttribute("phone", phone);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/WEB-INF/addReaderForm.jsp").forward(request, response);
                    break;
                }
                //request.getRequestDispatcher("/WEB-INF/addUserForm.jsp").forward(request, response);
                //request.getRequestDispatcher("/index.jsp").forward(request, response);

                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String role = request.getParameter("role");
                if("".equals(login) || login == null
                        ||"".equals(password) || password == null
                        ||"".equals(role) || role == null){
                    request.setAttribute("login", login);
                    request.setAttribute("password", password);
                    request.setAttribute("role", role);
                    request.setAttribute("info", "Заполните все поля");
                    request.getRequestDispatcher("/WEB-INF/addUserForm.jsp").forward(request, response);
                    break;
                }
                Reader reader = new Reader(firstname, lastname, phone);
                User user = new User(login, password, role, reader);
                readerFacade.create(reader);
                userFacade.create(user);
                request.setAttribute("info", "Пользователь \"" + reader.getFirstname()+" "+ reader.getLastname() + "\" добавлен");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            case "/listReaders":
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/WEB-INF/listReaders.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
