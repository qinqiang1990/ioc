import org.jsoup.nodes.Document;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.crawler.DeepCrawler;
import cn.edu.hfut.dmic.webcollector.fetcher.Visitor;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class MyCrawler extends  DeepCrawler{

	public MyCrawler(String crawlPath) {
		super(crawlPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Links visitAndGetNextLinks(Page page) {
		// TODO Auto-generated method stub
		 Document doc = page.getDoc();
	        String title = doc.title();
	        System.out.println("URL:" + page.getUrl() + "  ����:" + title);
	        System.out.println("Content:" + doc.html());

		return null;
	}
  
	 public static void main(String[] args) throws Exception {
	        /*���캯���е�string,�������crawlPath���������ȡ��Ϣ������crawlPath�ļ�����,
	          ��ͬ��������ʹ�ò�ͬ��crawlPath
	        */
		 	MyCrawler crawler = new MyCrawler("D:\\home.txt");
	       // crawler.setThreads(50);
	        crawler.addSeed("http://www.zhihu.com/");
	        crawler.setResumable(false);
	        crawler.start(1);
	 }
}
  
