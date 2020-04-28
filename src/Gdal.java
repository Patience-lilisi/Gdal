import org.gdal.gdal.gdal;
import org.gdal.ogr.DataSource;
import org.gdal.ogr.Driver;
import org.gdal.ogr.ogr;

public class Gdal {
	public static void main(String[] args) {
		ogr.RegisterAll();
		gdal.SetConfigOption("GDAL_FILENAME_IS_UTF8","YES");
		gdal.SetConfigOption("SHAPE_ENCODING",""); 
//		String strVectorFile = "D:\\Gdal\\Dwg.Dwg"; 
		String strVectorFile = "F:\\GISdb\\no_map.dxf";
		DataSource ds = ogr.Open(strVectorFile,0);
        if (ds == null)  
        {  
            System.out.println("打开文件失败！" );  
            return;  
        }
        System.out.println("打开文件成功！" );  
        Driver dv = ogr.GetDriverByName("GeoJSON");  
        if(dv == null) {
            System.out.println("打开驱动失败！" );  
            return;  
        }
        System.out.println("打开驱动成功！" );  
        dv.CopyDataSource(ds, "D:\\Gdal\\Dgn.geojson");
        System.out.println("转换成功！" ); 
	}
}
