package C1_Pattern.C_behavior;


interface Handler {
    void setHandler(Handler handler);
    void process(Filem filem);
    String getHandlerName();
}


class Filem {
    private final String fileName;
    private final String fileType;
    private final String filePath;

    public Filem(String fileName, String fileType, String filePath){
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
    }

    public String getFilemName() {
        return fileName;
    }

    public String getFilemType() {
        return fileType;
    }

    public String getFilemPath() {
        return filePath;
    }
}

//----------------------------------------------------------------------------------------------------------------------
class ImageFileHandler implements Handler{
    private Handler handler;
    private String handlerName;

    public ImageFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(Filem filem) {

        if(filem.getFilemType().equals("image")){
            System.out.println("Process and saving image file... by "+handlerName);
        }else if(handler!=null){
            System.out.println(handlerName+" fowards request to "+handler.getHandlerName());
            handler.process(filem);
        }else{
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}


class ExcelFileHandler implements Handler{
    private Handler handler;
    private String handlerName;

    public ExcelFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(Filem filem) {

        if(filem.getFilemType().equals("excel")){
            System.out.println("Process and saving excel file... by "+handlerName);
        }else if(handler!=null){
            System.out.println(handlerName+" fowards request to "+handler.getHandlerName());
            handler.process(filem);
        }else{
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}


class DocFileHandler implements Handler{
    private Handler handler;
    private String handlerName;

    public DocFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(Filem filem) {

        if(filem.getFilemType().equals("doc")){
            System.out.println("Process and saving doc file... by "+handlerName);
        }else if(handler!=null){
            System.out.println(handlerName+" fowards request to "+handler.getHandlerName());
            handler.process(filem);
        }else{
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}


class AudioFileHandler implements Handler{
    private Handler handler;
    private String handlerName;

    public AudioFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(Filem filem) {

        if(filem.getFilemType().equals("audio")){
            System.out.println("Process and saving audio file... by "+handlerName);
        }else if(handler!=null){
            System.out.println(handlerName+" fowards request to "+handler.getHandlerName());
            handler.process(filem);
        }else{
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}


class TextFileHandler implements Handler{
    private Handler handler;
    private String handlerName;

    public TextFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {           // через метод в поле handler посылается следующий обработчик
        this.handler = handler;
    }

    @Override                                           // основной метод
    public void process(Filem filem) {
        if(filem.getFilemType().equals("text")){
            System.out.println("Process and saving text file... by "+ handlerName);
        }else if(handler!= null){
            System.out.println(handlerName+" fowards request to "+ handler.getHandlerName());
            handler.process(filem);
        }else{
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {                                // получение названия обработчика - не обязательно
        return handlerName;
    }
}


class VideoFileHandler implements Handler{
    private Handler handler;
    private String handlerName;

    public VideoFileHandler(String handlerName){
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(Filem filem) {

        if(filem.getFilemType().equals("video")){
            System.out.println("Process and saving video file... by "+handlerName);
        }else if(handler!=null){
            System.out.println(handlerName+" fowards request to "+handler.getHandlerName());
            handler.process(filem);
        }else{
            System.out.println("File not supported");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}


//----------------------------------------------------------------------------------------------------------------------
public class N1_ChainOfReponsibility {
    public static void main(String[] args) {
        Filem filem = null;
        Handler textHandler = new TextFileHandler("Text Handler");
        Handler docHandler = new DocFileHandler("Doc Handler");
        Handler excelHandler = new ExcelFileHandler("Excel Handler");
        Handler audioHandler = new AudioFileHandler("Audio Handler");
        Handler videoHandler = new VideoFileHandler("Video Handler");
        Handler imageHandler = new ImageFileHandler("Image Handler");

        textHandler.setHandler(docHandler);
        docHandler.setHandler(excelHandler);
        excelHandler.setHandler(audioHandler);
        audioHandler.setHandler(videoHandler);
        videoHandler.setHandler(imageHandler);

        //пример 1
        filem = new Filem("Abc.mp3", "audio", "C:");
        textHandler.process(filem);
        System.out.println("---------------------------------");

        //пример 2
        filem = new Filem("Abc.jpg", "video", "C:");
        textHandler.process(filem);
        System.out.println("---------------------------------");

        //пример 3
        filem = new Filem("Abc.doc", "doc", "C:");
        textHandler.process(filem);
        System.out.println("---------------------------------");

        //пример 4
        filem = new Filem("Abc.bat", "bat", "C:");
        textHandler.process(filem);
    }
}

//    В примере:
//          - создали разные обработчики и связали их в цепочку
//               (цепочка начинается с текстового обработчика, который используется для обработки текстовых файлов,
//                до обработчика документа и так далее, до последнего обработчика, обработчика изображения)
//          - создали различные файловые объекты и передали его текстовому обработчику.
//
//          Если файл может быть обработан текстовым обработчиком, он делает это, в противном случае он пересылает файл следующему
//     связанному обработчику.
//          В результате видно, что  запрошенный файл был перенаправлен связанными объектами, пока он не достиг соответствующего обработчика
//
//          Важно, мы не создали обработчик для обработки файла bat.
//              - поэтому он проходит через все обработчики и приводит к выводу «Файл не поддерживается».
//
//          Код клиента отделен от обслуживаемого объекта.
//          Он только отправляет запрос, и запрос обрабатывается любым из обработчиков в цепочке или не обрабатывается в случае его поддержки.
