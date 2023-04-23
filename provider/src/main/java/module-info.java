import org.example.provider.Addition;
import org.example.provider.Subtraction;
import org.example.service.Calculate;

module org.example.provider {
    exports org.example.provider;
    requires org.example.service;
    provides Calculate with Addition, Subtraction;
}