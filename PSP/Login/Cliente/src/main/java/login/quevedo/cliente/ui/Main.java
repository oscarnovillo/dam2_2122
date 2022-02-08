package login.quevedo.cliente.ui;

import io.reactivex.rxjava3.schedulers.Schedulers;
import login.quevedo.cliente.data.CacheAuthorization;
import login.quevedo.cliente.data.DaoEstupido;
import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {


        CacheAuthorization ca = new CacheAuthorization();
        ca.setUser("user");
        ca.setPass("pass");


        CompletableFuture.runAsync(() -> {

            DaoEstupido dao = new DaoEstupido(ca);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dao.getAlumno().observeOn(Schedulers.single())
                    .blockingSubscribe(either -> {
                        if (either.isRight()) {
                            System.out.println(either.get());

                        } else if (either.isLeft()) {
                            System.out.println(either.getLeft());

                        }


                    });

            dao.getJwt().observeOn(Schedulers.single())
                    .blockingSubscribe(either -> {
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


        }).join();

    }


}
