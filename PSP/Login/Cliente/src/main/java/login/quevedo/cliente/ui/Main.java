package login.quevedo.cliente.ui;

import io.reactivex.rxjava3.schedulers.Schedulers;
import login.quevedo.cliente.data.CacheAuthorization;
import login.quevedo.cliente.data.DaoEstupido;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {


        CacheAuthorization ca = new CacheAuthorization();
        ca.setUser("user");
        ca.setPass("pass");


        DaoEstupido dao = new DaoEstupido(ca);

        dao.getAlumno().observeOn(Schedulers.io())
                .subscribe(either -> {
                    if (either.isRight()) {
                        System.out.println(either.get());

                    } else if (either.isLeft()) {
                        System.out.println(either.getLeft());

                    }


                });

        dao.getJwt().observeOn(Schedulers.io())
                .subscribe(either -> {
                    if (either.isRight()) {

                        System.out.println(either.get());
                        dao.getVerify().observeOn(Schedulers.io())
                                .subscribe(either2 -> {
                                    if (either2.isRight()) {
                                        System.out.println(either2.get());

                                    } else if (either2.isLeft()) {
                                        System.out.println(either2.getLeft());

                                    }


                                });


                    } else if (either.isLeft()) {
                        System.out.println(either.getLeft());

                    }


                });




        Thread.sleep(5000);
    }


}
