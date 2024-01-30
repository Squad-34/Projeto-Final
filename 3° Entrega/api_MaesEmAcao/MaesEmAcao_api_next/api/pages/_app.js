import '@/styles/globals.css'
 
import { UserProvider } from '../context/userContext';
import Navbar from '@/components/navbar';
import Footer from '@/components/footer';
 
function MyApp({ Component, pageProps }) {
  return (
    <UserProvider>
      <Navbar />
      <Component {...pageProps} />
      <Footer/>
    </UserProvider>
  );
}
 
export default MyApp;
 