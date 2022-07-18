
1 - baixar dependencias
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update

2 - install ingress
helm install nginx-ingress ingress-nginx/ingress-nginx --set controller.publishService.enabled=true

kubectl --namespace default get services -o wide -w nginx-ingress-ingress-nginx-controller



3 - Instalar helm de certificado manager
kubectl apply -f https://github.com/cert-manager/cert-manager/releases/download/v1.8.2/cert-manager.yaml