import org.example.provider.addition;
import org.example.provider.subtraction;
import org.example.service.Calculate;

module org.example.provider {
    exports org.example.provider;
    requires org.example.service;
    provides Calculate with addition, subtraction;
}