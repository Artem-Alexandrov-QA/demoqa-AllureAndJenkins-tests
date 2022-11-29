package page;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;
public class CalendarComponent {

    public void setDate(String day, String moth, String year) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(moth);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-moth)").click();
    }
}

