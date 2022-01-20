package login.quevedo.cliente.ui;

import io.reactivex.rxjava3.schedulers.Schedulers;
import login.quevedo.cliente.data.DaoEstupido;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {


        DaoEstupido dao = new DaoEstupido();

        dao.getAlumno().observeOn(Schedulers.io())
                .subscribe(either -> {
                    if (either.isRight()) {
                        System.out.println(either.get());

                    } else if (either.isLeft()) {
                        System.out.println(either.getLeft());

                    }


                });

        Thread.sleep(5000);
    }


}
