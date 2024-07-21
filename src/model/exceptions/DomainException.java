package model.exceptions;

public class DomainException extends RuntimeException{ //RuntimeException não obriga a fazer tratamento de erros, porém se os erros não forem colocados no bloco catch, o programa pode quebrar
        private static final long serialVersionUID = 1L;

        public DomainException(String msg){
            super(msg);
        }

}
