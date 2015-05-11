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
	        System.out.println("URL:" + page.getUrl() + "  标题:" + title);
	        System.out.println("Content:" + doc.html());

		return null;
	}
  
	 public static void main(String[] args) throws Exception {
	        /*构造函数中的string,是爬虫的crawlPath，爬虫的爬取信息都存在crawlPath文件夹中,
	          不同的爬虫请使用不同的crawlPath
	        */
		 	MyCrawler crawler = new MyCrawler("D:\\home.txt");
	       // crawler.setThreads(50);
	        crawler.addSeed("http://www.zhihu.com/");
	        crawler.setResumable(false);
	        crawler.start(1);
	 }
}
  
