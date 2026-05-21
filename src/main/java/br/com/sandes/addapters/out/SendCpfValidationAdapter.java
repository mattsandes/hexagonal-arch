package br.com.sandes.addapters.out;

import br.com.sandes.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    private final KafkaTemplate<String, String> template;

    public SendCpfValidationAdapter(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Override
    public void send(String cpf) {
        template.send("tp-cpf-validation", cpf);
    }
}
