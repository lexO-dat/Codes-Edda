import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class Platform {
    Video head;
    Video auxiliar = head;

    Platform(){
        head = null;
    }

    static class Video {
        String videoID;
        String videoTitle;
        String channelID;
        String channelTitle;
        String publishedAt;
        long viewCount;
        long likeCount;
        long popularidad;
        long commentCount;
        

        Video next;
        Video(String videoID, String videoTitle, String channelID, String channelTitle, String publishedAt, long viewCount, long likeCount, long commentCount){
            this.videoID = videoID;
            this.videoTitle = videoTitle;
            this.channelID = channelID;
            this.channelTitle = channelTitle;
            this.publishedAt = publishedAt;
            this.viewCount = viewCount;
            this.likeCount = likeCount;
            this.commentCount = commentCount;
            
            //agregado el calculo y el parametro de popularidad
            if(likeCount == 0){
                this.popularidad = 0;
            }else{
                this.popularidad = viewCount/likeCount;
            }
        }

        void play(){
            System.out.println(videoID +" "+videoTitle);
        }
    }

    Video begin(){
        return head;
    }

    Video arrayToVideo(ArrayList<String> array){

        long temp, temp2, temp3;

        if(array.get(5) == ""){
            temp = 0;
        }else{
            temp = Long.parseLong(array.get(5));
        }
        
        if(array.get(6) == ""){
            temp2 = 0;
        }else{
            temp2 = Long.parseLong(array.get(6));
        }

        if(array.get(7) == ""){
            temp3 = 0;
        }else{
            temp3 = Long.parseLong(array.get(7));
        }

        Video v = new Video(array.get(0), array.get(1), array.get(2), array.get(3), array.get(4), temp, temp2, temp3);
        
        return v;
    }
    
    void insertFromFile(String file){
        String string;
        //boolean first = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file));){
            //Skip first
            br.readLine();
            while((string = br.readLine()) != null){
                boolean inQuotes = false;
                int start = 0;
                ArrayList<String> newLines = new ArrayList<>();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '\"') {
                        inQuotes = !inQuotes;
                    } else if (string.charAt(i) == ',' && !inQuotes) {
                        newLines.add(string.substring(start, i));
                        start = i + 1;
                    }
                }
                newLines.add(string.substring(start));

                Video newVideo = arrayToVideo(newLines);

                insertAtEnd(newVideo);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void iterativePrint(Video v){
        Video actual = v;
        //Dentro del while saque el v.next
        while (actual != null){
            actual.play();
            actual = actual.next;
        }
    }

    void insertAtEnd(Video v){
        if(auxiliar == null){
            head = v;
            auxiliar = v;
        }else{
            auxiliar.next = v;
            auxiliar = v;
        }
    }

    Video search(Video v, String videoID){
        Video aux = v;
        while (aux != null){
            if (aux.videoID.equals(videoID)){
                System.out.print("search: ");
                aux.play();
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    void reverse(Video v){
        if (head == null ) {
            return;
        }

        Video prev = null;
        Video aux = head;
        Video next= null;

        while (aux != null) {
            next = aux.next;
            aux.next = prev;
            prev = aux;
            aux = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        //pruebas para la API
        Platform platform = new Platform();
        String file = "YoutubeDTSV2.csv";
        platform.insertFromFile(file);
        platform.reverse(platform.begin());
        platform.iterativePrint(platform.begin());
        platform.search(platform.begin(), "y83x7MgzWOA");
    }
}
