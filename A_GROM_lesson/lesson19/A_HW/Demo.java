package A_GROM_lesson.lesson19.A_HW;

public class Demo {
    public static void main(String[] args) {
    //файлы с характеристиками
        File file=new File(25,"tedfd","txt",31744l);
        File file1=new File(26,"java","doc",29786l);
        File file2=new File(27,"price","xls",80588l);
        File file3=new File(28,"pictures","jpeg",120568l);
        File file4=new File(29,"onemoment","jpeg",28475l);
        File file5=new File(30,"javaxl","doc",100001l);

        File file6=new File(31,"total","xls",80745l);
        File file7=new File(32,"fixer","doc",37894l);
        File file8=new File(33,"notepad","txt",120000l);
        File file9=new File(34,"girl","doc",29874l);
        File file10=new File(35,"float1","png",40869l);
        File file11=new File(36,"float2","xls",40869l);

        File file12=new File(37,"total1","xls",80745l);
        File file13=new File(38,"fixer1","doc",37894l);
        File file14=new File(39,"notepad1","txt",120000l);
        File file15=new File(40,"girl1","doc",29874l);
        File file16=new File(41,"float3","xls",40869l);
        File file17=new File(42,"float4","xls",40869l);


    //массив файлов - для хранилища
        File[] files11={file,file1,file2,file3,file4,file5,null,null,null,null};
        File[] files22={file6,file7,file8,file9,file10,file11,null,null,null,null};
        File[] files33={file12,null,file13,file14,file15,file16,file17,null,null,null,null,null};

    //формат поддерживаемых файлов в хранилище
        String[] formatSuppored={"txt","doc","xls","jpeg"};
        String[] formatSuppored11={"txt","doc","xls","png"};
        String[] formatSuppored22={"txt","doc","xls","jpeg","png"};


    //хранилище файлов
        Storage storage=new Storage(001,files11,formatSuppored,"Germany",558000);
        Storage storage2=new Storage(002,files22,formatSuppored11,"Ukraine",800000l);
        Storage storage3=new Storage(003,files33,formatSuppored22,"Korea",70000000l);

        Storage[] storageArray={storage,storage2,storage3};

    //Сontroller
        Controller controller=new Controller(storageArray);

    //проверка transferFile
        controller.transferFile(storage, storage3, 27);
        for(int i=0;i<files11.length;i++) {
            System.out.println(files11[i]);
        }
        System.out.println("");
        for(int i=0;i<files33.length;i++) {
            System.out.println(files33[i]);
        }

    //проверка transferFileAll
        controller.transferAll(storage, storage3);
        for(int i=0;i<files11.length;i++) {
            System.out.println(files11[i]);
        }
        System.out.println("");
        for(int i=0;i<files33.length;i++) {
            System.out.println(files33[i]);
        }
    }
}