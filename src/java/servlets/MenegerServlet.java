
package servlets;
import entity.Book;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.HistoryFacade;
import session.ReaderFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "MenegerServlet", urlPatterns = {
    "/addBook",
    "/createBook",
    "/editBookForm",
    "/editBook",
    "/listReaders"
    
})
public class MenegerServlet extends HttpServlet {
    @EJB
    private BookFacade bookFacade;
    @EJB
    private ReaderFacade readerFacade;
    @EJB
    private HistoryFacade historyFacade;
//    @EJB
//    private UserFacade userFacade;

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
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null){
            request.setAttribute("info", "У вас нет прав для доступа!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        User authUser = (User) httpSession.getAttribute("user");
        if(authUser == null){
            request.setAttribute("info", "У вас нет прав для доступа!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
        if(!"admin".equals(authUser.getLogin())){
            request.setAttribute("info", "У вас нет прав для доступа!");
            request.getRequestDispatcher("/loginForm").forward(request, response);
            return;
        }
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
            case "/editBookForm":
                String bookId = request.getParameter("bookId");
                book = bookFacade.find(Long.parseLong(bookId));
                request.setAttribute("book", book);
                request.getRequestDispatcher("/WEB-INF/editBookForm.jsp").forward(request, response);
                break;
            case "/editBook":
                bookId = request.getParameter("bookId");
                name = request.getParameter("name");
                author = request.getParameter("author");
                publishedYear = request.getParameter("publishedYear");
                if("".equals(name) || name == null
                        ||"".equals(author) || author == null
                        ||"".equals(publishedYear) || publishedYear == null){
                    request.setAttribute("info", "Поля не должны быть пустыми");
                    request.getRequestDispatcher("/editBookForm").forward(request, response);
                    break;
                }
                book = bookFacade.find(Long.parseLong(bookId));
                book.setName(name);
                book.setAuthor(author);
                book.setPublishedYear(publishedYear);
                bookFacade.edit(book);
                request.setAttribute("bookId", bookId);
                request.setAttribute("info", "Изменено");
                request.getRequestDispatcher("/editBookForm").forward(request, response);
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
